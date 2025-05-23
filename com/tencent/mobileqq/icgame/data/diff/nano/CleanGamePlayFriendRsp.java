package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class CleanGamePlayFriendRsp extends ExtendableMessageNano<CleanGamePlayFriendRsp> {
    private static volatile CleanGamePlayFriendRsp[] _emptyArray;

    public CleanGamePlayFriendRsp() {
        clear();
    }

    public static CleanGamePlayFriendRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CleanGamePlayFriendRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CleanGamePlayFriendRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CleanGamePlayFriendRsp) MessageNano.mergeFrom(new CleanGamePlayFriendRsp(), bArr);
    }

    public CleanGamePlayFriendRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static CleanGamePlayFriendRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CleanGamePlayFriendRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CleanGamePlayFriendRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
