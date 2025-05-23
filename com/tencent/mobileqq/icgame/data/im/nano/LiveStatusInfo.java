package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LiveStatusInfo extends ExtendableMessageNano<LiveStatusInfo> {
    private static volatile LiveStatusInfo[] _emptyArray;
    public String jumpUrl;
    public long liveRoomId;
    public int liveStatus;

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
        this.liveRoomId = 0L;
        this.liveStatus = 0;
        this.jumpUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.liveRoomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.liveStatus;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.jumpUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.liveRoomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.liveStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.jumpUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LiveStatusInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LiveStatusInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LiveStatusInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.liveRoomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.liveStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.jumpUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
