package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditHYUserInfoRsp extends ExtendableMessageNano<EditHYUserInfoRsp> {
    private static volatile EditHYUserInfoRsp[] _emptyArray;

    public EditHYUserInfoRsp() {
        clear();
    }

    public static EditHYUserInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditHYUserInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditHYUserInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditHYUserInfoRsp) MessageNano.mergeFrom(new EditHYUserInfoRsp(), bArr);
    }

    public EditHYUserInfoRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static EditHYUserInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditHYUserInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditHYUserInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
