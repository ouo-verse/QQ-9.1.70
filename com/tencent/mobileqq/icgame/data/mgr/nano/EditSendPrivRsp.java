package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class EditSendPrivRsp extends ExtendableMessageNano<EditSendPrivRsp> {
    private static volatile EditSendPrivRsp[] _emptyArray;

    public EditSendPrivRsp() {
        clear();
    }

    public static EditSendPrivRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditSendPrivRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditSendPrivRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditSendPrivRsp) MessageNano.mergeFrom(new EditSendPrivRsp(), bArr);
    }

    public EditSendPrivRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static EditSendPrivRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditSendPrivRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditSendPrivRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
