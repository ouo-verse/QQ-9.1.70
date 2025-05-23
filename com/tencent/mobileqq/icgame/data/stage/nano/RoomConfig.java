package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RoomConfig extends ExtendableMessageNano<RoomConfig> {
    private static volatile RoomConfig[] _emptyArray;

    public RoomConfig() {
        clear();
    }

    public static RoomConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomConfig) MessageNano.mergeFrom(new RoomConfig(), bArr);
    }

    public RoomConfig clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static RoomConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
