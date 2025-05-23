package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LiveStatusInfo extends ExtendableMessageNano<LiveStatusInfo> {
    private static volatile LiveStatusInfo[] _emptyArray;
    public Map<Long, VideoChangeStatus> liveStatus;

    public LiveStatusInfo() {
        clear();
    }

    public static LiveStatusInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveStatusInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LiveStatusInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LiveStatusInfo) MessageNano.mergeFrom(new LiveStatusInfo(), bArr);
    }

    public LiveStatusInfo clear() {
        this.liveStatus = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Map<Long, VideoChangeStatus> map = this.liveStatus;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 1, 4, 11);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Long, VideoChangeStatus> map = this.liveStatus;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 4, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LiveStatusInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LiveStatusInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LiveStatusInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.liveStatus = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.liveStatus, mapFactory, 4, 11, new VideoChangeStatus(), 8, 18);
            }
        }
    }
}
