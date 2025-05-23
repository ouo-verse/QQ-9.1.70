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
public final class ConfirmSecondIdentityAlertRsp extends ExtendableMessageNano<ConfirmSecondIdentityAlertRsp> {
    private static volatile ConfirmSecondIdentityAlertRsp[] _emptyArray;
    public long hasAlert;
    public long uid;

    public ConfirmSecondIdentityAlertRsp() {
        clear();
    }

    public static ConfirmSecondIdentityAlertRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ConfirmSecondIdentityAlertRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ConfirmSecondIdentityAlertRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ConfirmSecondIdentityAlertRsp) MessageNano.mergeFrom(new ConfirmSecondIdentityAlertRsp(), bArr);
    }

    public ConfirmSecondIdentityAlertRsp clear() {
        this.uid = 0L;
        this.hasAlert = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.hasAlert;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.hasAlert;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ConfirmSecondIdentityAlertRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ConfirmSecondIdentityAlertRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ConfirmSecondIdentityAlertRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.hasAlert = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
