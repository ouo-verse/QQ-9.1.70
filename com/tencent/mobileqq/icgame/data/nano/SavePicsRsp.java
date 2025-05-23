package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SavePicsRsp extends ExtendableMessageNano<SavePicsRsp> {
    private static volatile SavePicsRsp[] _emptyArray;

    public SavePicsRsp() {
        clear();
    }

    public static SavePicsRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SavePicsRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SavePicsRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SavePicsRsp) MessageNano.mergeFrom(new SavePicsRsp(), bArr);
    }

    public SavePicsRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SavePicsRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SavePicsRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SavePicsRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
