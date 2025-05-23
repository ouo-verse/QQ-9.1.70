package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditManagerInfoRsp extends ExtendableMessageNano<EditManagerInfoRsp> {
    private static volatile EditManagerInfoRsp[] _emptyArray;

    public EditManagerInfoRsp() {
        clear();
    }

    public static EditManagerInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditManagerInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditManagerInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditManagerInfoRsp) MessageNano.mergeFrom(new EditManagerInfoRsp(), bArr);
    }

    public EditManagerInfoRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static EditManagerInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditManagerInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditManagerInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
