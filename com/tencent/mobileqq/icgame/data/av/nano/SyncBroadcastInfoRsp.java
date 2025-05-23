package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SyncBroadcastInfoRsp extends ExtendableMessageNano<SyncBroadcastInfoRsp> {
    private static volatile SyncBroadcastInfoRsp[] _emptyArray;

    public SyncBroadcastInfoRsp() {
        clear();
    }

    public static SyncBroadcastInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SyncBroadcastInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SyncBroadcastInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SyncBroadcastInfoRsp) MessageNano.mergeFrom(new SyncBroadcastInfoRsp(), bArr);
    }

    public SyncBroadcastInfoRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SyncBroadcastInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SyncBroadcastInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SyncBroadcastInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
