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
public final class ConfirmSecondIdentityAlertReq extends ExtendableMessageNano<ConfirmSecondIdentityAlertReq> {
    private static volatile ConfirmSecondIdentityAlertReq[] _emptyArray;
    public long uid;

    public ConfirmSecondIdentityAlertReq() {
        clear();
    }

    public static ConfirmSecondIdentityAlertReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ConfirmSecondIdentityAlertReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ConfirmSecondIdentityAlertReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ConfirmSecondIdentityAlertReq) MessageNano.mergeFrom(new ConfirmSecondIdentityAlertReq(), bArr);
    }

    public ConfirmSecondIdentityAlertReq clear() {
        this.uid = 0L;
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
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ConfirmSecondIdentityAlertReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ConfirmSecondIdentityAlertReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ConfirmSecondIdentityAlertReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
