package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RoomInfo extends ExtendableMessageNano<RoomInfo> {
    private static volatile RoomInfo[] _emptyArray;
    public String chatRoomId;
    public long groupCode;
    public String pic;
    public int roomId;
    public String roomName;
    public int roomShowNo;
    public int roomType;

    public RoomInfo() {
        clear();
    }

    public static RoomInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomInfo) MessageNano.mergeFrom(new RoomInfo(), bArr);
    }

    public RoomInfo clear() {
        this.roomId = 0;
        this.roomName = "";
        this.chatRoomId = "";
        this.roomShowNo = 0;
        this.groupCode = 0L;
        this.pic = "";
        this.roomType = 0;
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
        if (!this.roomName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roomName);
        }
        if (!this.chatRoomId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.chatRoomId);
        }
        int i16 = this.roomShowNo;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        long j3 = this.groupCode;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.pic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.pic);
        }
        int i17 = this.roomType;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.roomName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomName);
        }
        if (!this.chatRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.chatRoomId);
        }
        int i16 = this.roomShowNo;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        long j3 = this.groupCode;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.pic.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.pic);
        }
        int i17 = this.roomType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.roomName = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.chatRoomId = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.roomShowNo = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.groupCode = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.pic = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
