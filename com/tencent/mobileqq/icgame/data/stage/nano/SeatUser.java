package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SeatUser extends ExtendableMessageNano<SeatUser> {
    private static volatile SeatUser[] _emptyArray;
    public int avRight;
    public int clientType;
    public long deviceStatus;
    public String ext;
    public long inviteUid;
    public int liveTime;
    public String rtmp;
    public long timestamp;
    public long tinyid;
    public long uid;

    public SeatUser() {
        clear();
    }

    public static SeatUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeatUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeatUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeatUser) MessageNano.mergeFrom(new SeatUser(), bArr);
    }

    public SeatUser clear() {
        this.uid = 0L;
        this.avRight = 0;
        this.timestamp = 0L;
        this.inviteUid = 0L;
        this.liveTime = 0;
        this.tinyid = 0L;
        this.deviceStatus = 0L;
        this.clientType = 0;
        this.rtmp = "";
        this.ext = "";
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
        int i3 = this.avRight;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.inviteUid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        int i16 = this.liveTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        long j18 = this.tinyid;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j18);
        }
        long j19 = this.deviceStatus;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j19);
        }
        int i17 = this.clientType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i17);
        }
        if (!this.rtmp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.rtmp);
        }
        if (!this.ext.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.ext);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.avRight;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.inviteUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        int i16 = this.liveTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        long j18 = this.tinyid;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j18);
        }
        long j19 = this.deviceStatus;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j19);
        }
        int i17 = this.clientType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i17);
        }
        if (!this.rtmp.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.rtmp);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.ext);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SeatUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeatUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeatUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.avRight = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.inviteUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.liveTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.tinyid = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.deviceStatus = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.clientType = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.rtmp = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.ext = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
