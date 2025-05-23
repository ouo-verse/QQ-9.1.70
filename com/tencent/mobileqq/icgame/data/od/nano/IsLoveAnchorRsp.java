package com.tencent.mobileqq.icgame.data.od.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class IsLoveAnchorRsp extends ExtendableMessageNano<IsLoveAnchorRsp> {
    private static volatile IsLoveAnchorRsp[] _emptyArray;
    public boolean isAnchor;
    public int retcode;

    public IsLoveAnchorRsp() {
        clear();
    }

    public static IsLoveAnchorRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new IsLoveAnchorRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static IsLoveAnchorRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (IsLoveAnchorRsp) MessageNano.mergeFrom(new IsLoveAnchorRsp(), bArr);
    }

    public IsLoveAnchorRsp clear() {
        this.isAnchor = false;
        this.retcode = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.isAnchor;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.retcode;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.isAnchor;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static IsLoveAnchorRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new IsLoveAnchorRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public IsLoveAnchorRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.isAnchor = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.retcode = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
