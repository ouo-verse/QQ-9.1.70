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
public final class LoginCheckReq extends ExtendableMessageNano<LoginCheckReq> {
    private static volatile LoginCheckReq[] _emptyArray;
    public boolean isTest;
    public boolean refresh;

    public LoginCheckReq() {
        clear();
    }

    public static LoginCheckReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LoginCheckReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LoginCheckReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LoginCheckReq) MessageNano.mergeFrom(new LoginCheckReq(), bArr);
    }

    public LoginCheckReq clear() {
        this.refresh = false;
        this.isTest = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.refresh;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.isTest;
        if (z17) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.refresh;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.isTest;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LoginCheckReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LoginCheckReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LoginCheckReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.refresh = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isTest = codedInputByteBufferNano.readBool();
            }
        }
    }
}
