package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SurvivalDetectionRsp extends ExtendableMessageNano<SurvivalDetectionRsp> {
    private static volatile SurvivalDetectionRsp[] _emptyArray;

    public SurvivalDetectionRsp() {
        clear();
    }

    public static SurvivalDetectionRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SurvivalDetectionRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SurvivalDetectionRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SurvivalDetectionRsp) MessageNano.mergeFrom(new SurvivalDetectionRsp(), bArr);
    }

    public SurvivalDetectionRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SurvivalDetectionRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SurvivalDetectionRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SurvivalDetectionRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
