package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditStageConfigRsp extends ExtendableMessageNano<EditStageConfigRsp> {
    private static volatile EditStageConfigRsp[] _emptyArray;

    public EditStageConfigRsp() {
        clear();
    }

    public static EditStageConfigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditStageConfigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditStageConfigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditStageConfigRsp) MessageNano.mergeFrom(new EditStageConfigRsp(), bArr);
    }

    public EditStageConfigRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static EditStageConfigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditStageConfigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditStageConfigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
