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
public final class AvRoomStatusReportReq extends ExtendableMessageNano<AvRoomStatusReportReq> {
    private static volatile AvRoomStatusReportReq[] _emptyArray;
    public byte[] extra;
    public MediaInfo mediaInfo;
    public int roomId;
    public int status;

    public AvRoomStatusReportReq() {
        clear();
    }

    public static AvRoomStatusReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AvRoomStatusReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AvRoomStatusReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AvRoomStatusReportReq) MessageNano.mergeFrom(new AvRoomStatusReportReq(), bArr);
    }

    public AvRoomStatusReportReq clear() {
        this.roomId = 0;
        this.status = 0;
        this.mediaInfo = null;
        this.extra = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(2, this.status);
        MediaInfo mediaInfo = this.mediaInfo;
        if (mediaInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, mediaInfo);
        }
        if (!Arrays.equals(this.extra, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.extra);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt32(2, this.status);
        MediaInfo mediaInfo = this.mediaInfo;
        if (mediaInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, mediaInfo);
        }
        if (!Arrays.equals(this.extra, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.extra);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AvRoomStatusReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AvRoomStatusReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AvRoomStatusReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.mediaInfo == null) {
                    this.mediaInfo = new MediaInfo();
                }
                codedInputByteBufferNano.readMessage(this.mediaInfo);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.extra = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
