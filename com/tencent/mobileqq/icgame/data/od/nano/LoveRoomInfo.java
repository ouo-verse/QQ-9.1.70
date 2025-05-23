package com.tencent.mobileqq.icgame.data.od.nano;

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
public final class LoveRoomInfo extends ExtendableMessageNano<LoveRoomInfo> {
    private static volatile LoveRoomInfo[] _emptyArray;
    public byte[] anchorLogo;
    public byte[] anchorNick;
    public long anchorUid;
    public int roomId;
    public byte[] roomName;
    public byte[] roomPic;
    public int status;

    public LoveRoomInfo() {
        clear();
    }

    public static LoveRoomInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LoveRoomInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LoveRoomInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LoveRoomInfo) MessageNano.mergeFrom(new LoveRoomInfo(), bArr);
    }

    public LoveRoomInfo clear() {
        this.roomId = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.roomName = bArr;
        this.roomPic = bArr;
        this.status = 0;
        this.anchorUid = 0L;
        this.anchorNick = bArr;
        this.anchorLogo = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        byte[] bArr = this.roomName;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.roomName);
        }
        if (!Arrays.equals(this.roomPic, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.roomPic);
        }
        int i16 = this.status;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!Arrays.equals(this.anchorNick, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.anchorNick);
        }
        if (!Arrays.equals(this.anchorLogo, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(7, this.anchorLogo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        byte[] bArr = this.roomName;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.roomName);
        }
        if (!Arrays.equals(this.roomPic, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.roomPic);
        }
        int i16 = this.status;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!Arrays.equals(this.anchorNick, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.anchorNick);
        }
        if (!Arrays.equals(this.anchorLogo, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.anchorLogo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LoveRoomInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LoveRoomInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LoveRoomInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.roomName = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                this.roomPic = codedInputByteBufferNano.readBytes();
            } else if (readTag == 32) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.anchorNick = codedInputByteBufferNano.readBytes();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.anchorLogo = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
