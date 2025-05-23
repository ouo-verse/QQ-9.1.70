package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AnchorStatus extends ExtendableMessageNano<AnchorStatus> {
    private static volatile AnchorStatus[] _emptyArray;
    public int beginTime;
    public int clientType;
    public byte[] extra;
    public int lastHeartbeat;
    public int liveType;
    public long roomid;
    public int status;
    public long uid;

    public AnchorStatus() {
        clear();
    }

    public static AnchorStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorStatus) MessageNano.mergeFrom(new AnchorStatus(), bArr);
    }

    public AnchorStatus clear() {
        this.uid = 0L;
        this.lastHeartbeat = 0;
        this.status = 0;
        this.liveType = 0;
        this.beginTime = 0;
        this.roomid = 0L;
        this.clientType = 0;
        this.extra = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.lastHeartbeat;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.status;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.liveType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.beginTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        long j16 = this.roomid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        int i19 = this.clientType;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        if (!Arrays.equals(this.extra, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(8, this.extra);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.lastHeartbeat;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.status;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.liveType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.beginTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        long j16 = this.roomid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        int i19 = this.clientType;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        if (!Arrays.equals(this.extra, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(8, this.extra);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorStatus().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.lastHeartbeat = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.liveType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.beginTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.roomid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 56) {
                this.clientType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.extra = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
