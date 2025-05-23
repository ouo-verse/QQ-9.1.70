package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class ExitGamePlayFriendRsp extends ExtendableMessageNano<ExitGamePlayFriendRsp> {
    private static volatile ExitGamePlayFriendRsp[] _emptyArray;

    public ExitGamePlayFriendRsp() {
        clear();
    }

    public static ExitGamePlayFriendRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExitGamePlayFriendRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExitGamePlayFriendRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExitGamePlayFriendRsp) MessageNano.mergeFrom(new ExitGamePlayFriendRsp(), bArr);
    }

    public ExitGamePlayFriendRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static ExitGamePlayFriendRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExitGamePlayFriendRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExitGamePlayFriendRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
