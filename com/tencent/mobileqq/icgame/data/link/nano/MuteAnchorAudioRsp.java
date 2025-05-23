package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MuteAnchorAudioRsp extends ExtendableMessageNano<MuteAnchorAudioRsp> {
    private static volatile MuteAnchorAudioRsp[] _emptyArray;

    public MuteAnchorAudioRsp() {
        clear();
    }

    public static MuteAnchorAudioRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MuteAnchorAudioRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MuteAnchorAudioRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MuteAnchorAudioRsp) MessageNano.mergeFrom(new MuteAnchorAudioRsp(), bArr);
    }

    public MuteAnchorAudioRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static MuteAnchorAudioRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MuteAnchorAudioRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MuteAnchorAudioRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
