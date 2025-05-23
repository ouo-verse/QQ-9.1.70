package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetUserVoiceCoverRsp extends ExtendableMessageNano<SetUserVoiceCoverRsp> {
    private static volatile SetUserVoiceCoverRsp[] _emptyArray;

    public SetUserVoiceCoverRsp() {
        clear();
    }

    public static SetUserVoiceCoverRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetUserVoiceCoverRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetUserVoiceCoverRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetUserVoiceCoverRsp) MessageNano.mergeFrom(new SetUserVoiceCoverRsp(), bArr);
    }

    public SetUserVoiceCoverRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SetUserVoiceCoverRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetUserVoiceCoverRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetUserVoiceCoverRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
