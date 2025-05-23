package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SyncBroadcastInfo extends ExtendableMessageNano<SyncBroadcastInfo> {
    private static volatile SyncBroadcastInfo[] _emptyArray;
    public AvRoomStatusChgReq info;
    public int startTime;
    public int type;
    public long uid;

    public SyncBroadcastInfo() {
        clear();
    }

    public static SyncBroadcastInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SyncBroadcastInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SyncBroadcastInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SyncBroadcastInfo) MessageNano.mergeFrom(new SyncBroadcastInfo(), bArr);
    }

    public SyncBroadcastInfo clear() {
        this.type = 0;
        this.info = null;
        this.uid = 0L;
        this.startTime = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        AvRoomStatusChgReq avRoomStatusChgReq = this.info;
        if (avRoomStatusChgReq != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, avRoomStatusChgReq);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i16 = this.startTime;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        AvRoomStatusChgReq avRoomStatusChgReq = this.info;
        if (avRoomStatusChgReq != null) {
            codedOutputByteBufferNano.writeMessage(2, avRoomStatusChgReq);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i16 = this.startTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SyncBroadcastInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SyncBroadcastInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SyncBroadcastInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.info == null) {
                    this.info = new AvRoomStatusChgReq();
                }
                codedInputByteBufferNano.readMessage(this.info);
            } else if (readTag == 24) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.startTime = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
