package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SurvivalDetectionReq extends ExtendableMessageNano<SurvivalDetectionReq> {
    private static volatile SurvivalDetectionReq[] _emptyArray;

    public SurvivalDetectionReq() {
        clear();
    }

    public static SurvivalDetectionReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SurvivalDetectionReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SurvivalDetectionReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SurvivalDetectionReq) MessageNano.mergeFrom(new SurvivalDetectionReq(), bArr);
    }

    public SurvivalDetectionReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SurvivalDetectionReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SurvivalDetectionReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SurvivalDetectionReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
