package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class RoomPicPreviewMsg extends ExtendableMessageNano<RoomPicPreviewMsg> {
    private static volatile RoomPicPreviewMsg[] _emptyArray;
    public String filename;
    public long groupid;
    public int groupnum;
    public int height;
    public long sdkappid;
    public String sign;
    public long timestamp;
    public String url;
    public long userid;
    public int width;

    public RoomPicPreviewMsg() {
        clear();
    }

    public static RoomPicPreviewMsg[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomPicPreviewMsg[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomPicPreviewMsg parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomPicPreviewMsg) MessageNano.mergeFrom(new RoomPicPreviewMsg(), bArr);
    }

    public RoomPicPreviewMsg clear() {
        this.userid = 0L;
        this.groupnum = 0;
        this.sdkappid = 0L;
        this.filename = "";
        this.url = "";
        this.timestamp = 0L;
        this.sign = "";
        this.height = 0;
        this.width = 0;
        this.groupid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.userid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.groupnum;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        long j16 = this.sdkappid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        if (!this.filename.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.filename);
        }
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.url);
        }
        long j17 = this.timestamp;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j17);
        }
        if (!this.sign.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.sign);
        }
        int i16 = this.height;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        int i17 = this.width;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i17);
        }
        long j18 = this.groupid;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(10, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.userid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.groupnum;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        long j16 = this.sdkappid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        if (!this.filename.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.filename);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.url);
        }
        long j17 = this.timestamp;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j17);
        }
        if (!this.sign.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.sign);
        }
        int i16 = this.height;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        int i17 = this.width;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i17);
        }
        long j18 = this.groupid;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomPicPreviewMsg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomPicPreviewMsg().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomPicPreviewMsg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.userid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.groupnum = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.sdkappid = codedInputByteBufferNano.readInt64();
                    break;
                case 34:
                    this.filename = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.url = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.timestamp = codedInputByteBufferNano.readInt64();
                    break;
                case 58:
                    this.sign = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.height = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.width = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.groupid = codedInputByteBufferNano.readUInt64();
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
