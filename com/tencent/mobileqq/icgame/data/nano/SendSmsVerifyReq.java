package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SendSmsVerifyReq extends ExtendableMessageNano<SendSmsVerifyReq> {
    private static volatile SendSmsVerifyReq[] _emptyArray;

    public SendSmsVerifyReq() {
        clear();
    }

    public static SendSmsVerifyReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SendSmsVerifyReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SendSmsVerifyReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SendSmsVerifyReq) MessageNano.mergeFrom(new SendSmsVerifyReq(), bArr);
    }

    public SendSmsVerifyReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SendSmsVerifyReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SendSmsVerifyReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SendSmsVerifyReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int readTag;
        do {
            readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
        } while (storeUnknownField(codedInputByteBufferNano, readTag));
        return this;
    }
}
