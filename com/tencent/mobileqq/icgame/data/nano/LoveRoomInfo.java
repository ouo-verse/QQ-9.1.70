package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LoveRoomInfo extends ExtendableMessageNano<LoveRoomInfo> {
    private static volatile LoveRoomInfo[] _emptyArray;
    public String anchorLogo;
    public String anchorNick;
    public long anchorUid;
    public long roomId;
    public String roomName;
    public String roomPic;
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
        this.roomId = 0L;
        this.roomName = "";
        this.roomPic = "";
        this.status = 0;
        this.anchorUid = 0L;
        this.anchorNick = "";
        this.anchorLogo = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.roomName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roomName);
        }
        if (!this.roomPic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.roomPic);
        }
        int i3 = this.status;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!this.anchorNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.anchorNick);
        }
        if (!this.anchorLogo.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.anchorLogo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.roomName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomName);
        }
        if (!this.roomPic.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.roomPic);
        }
        int i3 = this.status;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!this.anchorNick.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.anchorNick);
        }
        if (!this.anchorLogo.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.anchorLogo);
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
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.roomName = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.roomPic = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.anchorNick = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.anchorLogo = codedInputByteBufferNano.readString();
            }
        }
    }
}
